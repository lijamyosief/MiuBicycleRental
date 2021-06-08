package edu.miu.seniorproject.eBicycleRental.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import edu.miu.seniorproject.eBicycleRental.model.*;
import edu.miu.seniorproject.eBicycleRental.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private AddressService addressService;

    private Booking booking;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private CredentialService credentialService;

    @GetMapping(value = "/ebicyclerental/customer/payments")
    public ModelAndView managePayments() {
        ModelAndView modelAndView = new ModelAndView();
        List<Payment> payments = paymentService.findAll();
        modelAndView.addObject("payments", payments);
        modelAndView.setViewName("customer/payments/payments");
        return  modelAndView;
    }

    @GetMapping(value = "/ebicyclerental/customer/payments/add")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public String newPaymentForm(@RequestParam ("book") Long bookId, Model model) {
//        System.out.println(httpServletRequest.);


        System.out.println("inside+++++"+bookId);

        Booking booking=bookingService.findById(bookId);

        Payment newPayment = new Payment();
        Address address=new Address();
        newPayment.setBillingAddress(address);
        newPayment.setBooking(booking);
        model.addAttribute("payment", newPayment);
        return "secured/customer/customers/paymentform";
    }

    @PostMapping(value = "/ebicyclerental/cutomer/payments/add/save")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public String addNewPayment(@Valid @ModelAttribute("payment") Payment payment, @RequestParam Long bookingId, BindingResult bindingResult, Model model) {
        System.out.println("entyry++");
        if(bindingResult.hasErrors()) {
            model.addAttribute("payment", payment);
            model.addAttribute("errors", bindingResult.getAllErrors());
            System.out.println("error inside payment++++");
            return "secured/customer/customers/paymentform";
        }
        if(payment.getBillingAddress().getStreet().trim().isEmpty()
                && payment.getBillingAddress().getCity().trim().isEmpty()
                && payment.getBillingAddress().getState().trim().isEmpty()
                && payment.getBillingAddress().getCountry().trim().isEmpty()
                && payment.getBillingAddress().getZipCode() == null) {
            payment.setBillingAddress(null);
        }
        Booking booking=bookingService.findById(bookingId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Credential credential=credentialService.findByUserName(auth.getName());
        User user=userService.findByCredential(credential);

        System.out.println("address++++");
        addressService.save(payment.getBillingAddress());

        booking.setUser(user);
        booking.setPayment(payment);

        payment.setPaymentDate(booking.getBookingDate());
        payment.setTotalPrice(booking.getTotalPrice());
        payment.setBooking(booking);
        System.out.println("payment++++");
        paymentService.save(payment);

        return "secured/customer/customers/paymentconfirmation";
    }



    @GetMapping(value = "/ebicyclerental/user/payments/edit/{paymentId}")
    public String editPaymentForm(@PathVariable("paymentId") Long paymentId, Model model) {
        Payment payment = paymentService.findById(paymentId);
        if (payment != null) {
            model.addAttribute("payment", payment);
            return "user/payments/editpaymentform";
        }
        return "user/payments/payments";
    }
    @GetMapping(value="/ebicyclerental/user/payment/delete/{paymentId}")
    public String deletePayment(@PathVariable("paymentId") Long id, Model model){
        paymentService.delete(id);
        return "redirect:/ebicyclerental/user/payments";
    }

//    @GetMapping(value = "/ebicyclerental/customer/customers/paymentconfirmation")
//    public String homePage1() {
//        return "secured/customer/customers/bookingform";
//    }

    public void addNewPayment(Booking newBooking) {
       booking=newBooking;
    }
}