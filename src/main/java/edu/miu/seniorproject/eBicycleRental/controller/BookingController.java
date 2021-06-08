package edu.miu.seniorproject.eBicycleRental.controller;

import edu.miu.seniorproject.eBicycleRental.model.*;
import edu.miu.seniorproject.eBicycleRental.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;



    @Controller
    public class BookingController {
        @Autowired
        private PaymentController paymentController;

        @Autowired
        private BookingService bookingService;

        @Autowired
        private VehicleService vehicleService;

        @Autowired
        private UserService userService;

        @Autowired
        private PaymentService paymentService;

        @Autowired
        private SearchController searchController;

        @Autowired
        private SearchService searchService;

        @RequestMapping(value = "/ebicyclerental/staff/bookinglist", method = RequestMethod.GET)
        public ModelAndView bookingsList() {
            List<Booking> bookings = bookingService.findAllOrderByDate();
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("bookings", bookings);
            modelAndView.setViewName("secured/staff/bookinglist");

            return modelAndView;
        }

        @RequestMapping(value = "/ebicyclerental/staff/booking/addnew", method = RequestMethod.GET)
        public String newBookingForm(Model model) {
            Booking newBooking = new Booking();
            newBooking.setReferenceNumber(bookingService.assignReferenceNumber());
            List<Vehicle> vehicles = vehicleService.findAll();
            List<User> users = userService.findAll();
            List<Payment> payments = paymentService.findAll();
            model.addAttribute("booking", newBooking);
            model.addAttribute("vehicles", vehicles);
            model.addAttribute("users", users);
            model.addAttribute("payments", payments);
            return "secured/staff/bookingform";
        }


        @PostMapping(value = "/ebicyclerental/staff/bookingform/save")
        public String addNewBooking(@Valid @ModelAttribute("booking") Booking booking,
                                    BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "secured/staff/bookingform";
            }

            booking = bookingService.save(booking);
            return "redirect:/ebicyclerental/staff/bookinglist";
        }

        @GetMapping(value = "/ebicyclerental/staff/booking/edit/{bookingId}")
        public String editBookingForm(@PathVariable("bookingId") Long bookingId, Model model) {
            Booking booking = bookingService.findById(bookingId);
                if (booking != null) {
                model.addAttribute("booking", booking);
                return "secured/staff/bookingeditform";
            }
            return "/ebicyclerental/staff/bookinglist";
        }

        @PostMapping(value = "/ebicyclerental/staff/bookings/update")
        public String updateBooking(@Valid @ModelAttribute("booking") Booking booking,
                                    BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "secured/staff/bookingeditform";
            }
            booking = bookingService.save(booking);
            return "redirect:/ebicyclerental/staff/bookinglist";
        }

        @GetMapping(value = "/ebicyclerental/staff/booking/delete/{bookingId}")
        public String deleteBooking(@PathVariable("bookingId") Long id) {
            System.out.println("deleting++");

            bookingService.delete(id);
            System.out.println("deleted++");
            return "redirect:/ebicyclerental/staff/bookinglist  ";
        }

        @RequestMapping(value = "/ebicyclerental/secured/customer/customers/newbookingform/{category}", method = RequestMethod.GET)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        public String newPublicBookingForm(Model model, @PathVariable("category") Category category) {
            Booking newBooking = new Booking();

            Payment newPayment = new Payment();
            newBooking.setPayment(newPayment);
            LocalDate start = searchController.getTemp().getStart();
            LocalDate end = searchController.getTemp().getEnd();
            Long dateDifference = (Long) (ChronoUnit.DAYS.between(start, end));
            Double unitPrice = category.getRatePerDay();
            Double totalPrice = (double) (dateDifference * unitPrice);
            newBooking.setTotalPrice(totalPrice);
            newBooking.setStartDate(start);
            newBooking.setEndDate(end);
            newBooking.setReferenceNumber(bookingService.assignReferenceNumber());
            newBooking.setBookingDate(LocalDate.now());
//            newBooking.setFirstName("simon");
//            newBooking.setLastName("abraham");
//            newBooking.setEmail("simon@gmail.com");
//            newBooking.setDateOfBirth(LocalDate.of(1999,02,03));
//            newBooking.setLicenseNumber(3432l);


//            newBooking.getPayment().setTotalPrice(newBooking.getTotalPrice());
//            paymentService.save(newBooking.getPayment());
            //newPayment.setBooking(newBooking);
//            paymentService.save(newPayment);
            newBooking.setVehicle(searchService.getAvailableVehicles(start, end)
                    .stream()
                    .filter(v -> v.getCategory() == category)
                    .findFirst()
                    .orElse(null));
            paymentController.addNewPayment(newBooking);
            model.addAttribute("booking", newBooking);
            return "secured/customer/customers/bookingform";
        }

        @PostMapping(value = "/ebicyclerental/customer/bookings/addnewbooking/save")
        @DateTimeFormat(pattern = "yyyy-MM-dd")

        public String addNewBookingCustomer(@Valid @ModelAttribute("booking") Booking booking,
                                          BindingResult bindingResult, Model model) {
            if (bindingResult.hasErrors()) {
                model.addAttribute("errors", bindingResult.getAllErrors());
                return "secured/customer/customers/bookingform";
            }

            booking = bookingService.save(booking);
            model.addAttribute("booking",booking);
//            return "redirect:/ebicyclerental/customer/bookings/success";
            return "secured/customer/customers/confirmation";
        }

        @GetMapping(value = "/ebicyclerental/customer/bookings/success")
        public String homePage() {
            return "secured/customer/customers/confirmation";
        }

    }


