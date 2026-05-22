package com.zeynep.akillitedariklojistik.controller;

import com.zeynep.akillitedariklojistik.service.OrderService;
import com.zeynep.akillitedariklojistik.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.zeynep.akillitedariklojistik.pattern.adapter.ArasCargoAdapter;
import com.zeynep.akillitedariklojistik.pattern.adapter.CargoService;
import com.zeynep.akillitedariklojistik.pattern.adapter.GlobalExpressCargoAdapter;
import com.zeynep.akillitedariklojistik.pattern.adapter.YurticiCargoAdapter;
import com.zeynep.akillitedariklojistik.model.payment.Payment;
import com.zeynep.akillitedariklojistik.pattern.factory.PaymentFactory;
import com.zeynep.akillitedariklojistik.model.log.SystemLogger;
import com.zeynep.akillitedariklojistik.pattern.decorator.BasicCargoPackage;
import com.zeynep.akillitedariklojistik.pattern.decorator.CargoPackage;
import com.zeynep.akillitedariklojistik.pattern.decorator.FragileItemDecorator;
import com.zeynep.akillitedariklojistik.pattern.decorator.InsuranceDecorator;
import com.zeynep.akillitedariklojistik.model.user.Role;
import com.zeynep.akillitedariklojistik.model.user.User;

@Controller
public class HomeController {

    private final ProductService productService;
    private final OrderService orderService;
    private final SystemLogger logger = SystemLogger.getInstance();

    public HomeController(ProductService productService) {
        this.productService = productService;
        this.orderService = new OrderService();
    }

    @GetMapping("/")
    public String homePage(Model model) {

        logger.log("Ana sayfa açıldı.");

        User adminUser =
                new User("Zeynep", Role.ADMIN);

        System.out.println("=== YETKİ SİSTEMİ ===");

        System.out.println(
                "Kullanıcı: "
                        + adminUser.getUsername()
        );

        System.out.println(
                "Rol: "
                        + adminUser.getRole()
        );

        System.out.println(
                "Stok Yönetebilir mi? "
                        + adminUser.canManageStock()
        );

        System.out.println(
                "Kargo Yönetebilir mi? "
                        + adminUser.canManageCargo()
        );

        if (orderService.getAllOrders().isEmpty()) {

            orderService.createOrder(
                    productService.getAllProducts().get(0),
                    2
            );

            orderService.createOrder(
                    productService.getAllProducts().get(1),
                    1
            );
        }

        model.addAttribute(
                "products",
                productService.getAllProducts()
        );

        model.addAttribute(
                "orders",
                orderService.getAllOrders()
        );

        logger.log("Kargo sistemi çalıştırıldı.");

        CargoService aras = new ArasCargoAdapter();

        CargoService yurtici = new YurticiCargoAdapter();

        CargoService global = new GlobalExpressCargoAdapter();

        System.out.println("=== KARGO SİSTEMİ ===");

        System.out.println(
                aras.getCargoCompanyName()
                        + " -> "
                        + aras.createTrackingCode()
        );

        System.out.println(
                "Ücret: "
                        + aras.calculatePrice(2.5, 300)
        );

        System.out.println(
                yurtici.getCargoCompanyName()
                        + " -> "
                        + yurtici.createTrackingCode()
        );

        System.out.println(
                global.getCargoCompanyName()
                        + " -> "
                        + global.createTrackingCode()
        );

        logger.log("Ödeme sistemi çalıştırıldı.");

        System.out.println("=== ÖDEME SİSTEMİ ===");

        PaymentFactory paymentFactory =
                new PaymentFactory();

        Payment creditCard =
                paymentFactory.createPayment("creditcard");

        Payment bankTransfer =
                paymentFactory.createPayment("banktransfer");

        Payment crypto =
                paymentFactory.createPayment("crypto");

        creditCard.pay(2500);

        bankTransfer.pay(1800);

        crypto.pay(5200);

        System.out.println("=== DECORATOR SİSTEMİ ===");

        CargoPackage cargoPackage =
                new BasicCargoPackage();

        cargoPackage =
                new InsuranceDecorator(cargoPackage);

        cargoPackage =
                new FragileItemDecorator(cargoPackage);

        System.out.println(
                cargoPackage.getDescription()
        );

        System.out.println(
                "Toplam Kargo Ücreti: "
                        + cargoPackage.getCost()
        );

        model.addAttribute("currentUser", adminUser);

        return "index";
    }

    @PostMapping("/add-product")
    public String addProduct(String name, double price, int stock) {

        productService.addSimpleProduct(name, price, stock);

        return "redirect:/";
    }

    @PostMapping("/approve-order")
    public String approveOrder(int orderId) {
        orderService.approveOrder(orderId); // State pattern tetiklenir!
        return "redirect:/";
    }
}