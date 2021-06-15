package com.airline.controller;

import com.airline.dto.*;
import com.airline.entity.*;
import com.airline.model.User;
import com.airline.repo.FoodRepository;
import com.airline.repo.PlaneRepository;
import com.airline.repo.UserRepository;
import com.airline.service.AdminService;
import com.airline.service.AirlineService;
import com.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.airline.config.CurrentUser;
import com.airline.util.GeneralUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {


	@Autowired
	private AdminService adminService;

	@Autowired
	private AirlineService airlineService;

	@Autowired
	private UserService userService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	MailSender emailSender;

	@Autowired
	protected JavaMailSender mailSender;

	@Autowired
	private FoodRepository foodRepository;

	private byte[] bytes;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getCurrentUser(@CurrentUser LocalUser user) {
		return ResponseEntity.ok(GeneralUtils.buildUserInfo(user));
	}

	@GetMapping("/all")
	public ResponseEntity<?> getContent() {
		return ResponseEntity.ok("Public content goes here");
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<?> getUserContent() {
		return ResponseEntity.ok("User content goes here");
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getAdminContent() {
		return ResponseEntity.ok("Admin content goes here");
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('MODERATOR')")
	public ResponseEntity<?> getModeratorContent() {
		return ResponseEntity.ok("Moderator content goes here");
	}

	@GetMapping("/crew")
	@PreAuthorize("hasRole('CREW')")
	public ResponseEntity<?> getCrewContent() {
		return ResponseEntity.ok("Crew content goes here");
	}

	@GetMapping("/fetchSeats")
	@PreAuthorize("hasRole('USER')")
	public List<Seat> fetchSeats(@RequestParam("flightId") int flightId){
		return airlineService.fetchSeats(flightId);
	}

	@PostMapping("/searchFlights")
	@PreAuthorize("hasRole('USER')")
	public List<Flight> searchFlights(@RequestBody SearchFlightsDT searchFlightsDT) {
		return airlineService.searchFlights(searchFlightsDT);
	}

	@PostMapping("/addBooking")
	@PreAuthorize("hasRole('USER')")
	public String addBooking(@RequestBody BookingDT bookingDT) {
		int bookingId = airlineService.addBooking(bookingDT);
		StatusDT status = new StatusDT();
		status.setGeneratedId(bookingId);
		status.setMessage("Ticket Booking in Progress");
		return null;
	}
	@GetMapping("/updateBooking")
	@PreAuthorize("hasRole('USER')")
	public void updateBooking(@RequestParam("bookingId") int bookingId) {
		airlineService.updateBooking(bookingId);
		System.out.println(bookingId);
	}

	@GetMapping("/fetchBooking")
	@PreAuthorize("hasRole('USER')")
	public List<Booking> fetchBookings(@RequestParam("userId") Long userId){
		return airlineService.fetchBookings(userId);
	}

	@GetMapping("/fetchTicket")
	@PreAuthorize("hasRole('USER')")
	public TicketDT fetchTicket(@RequestParam("bookingId") int bookingId) {

		TicketDT ticket = airlineService.fetchTicket(bookingId);
		return ticket;
	}

	@GetMapping("/cancelTicket")
	@PreAuthorize("hasRole('USER')")
	public double cancelBooking(@RequestParam("bookingId") int bookingId) {
		double refund = airlineService.cancelTicket(bookingId);
		return refund;
	}
	//////////////////////////////////////////////////////////////////////////////////////
	@PostMapping("/addFlight")
	@PreAuthorize("hasRole('MODERATOR')")
	public String addFlight(@RequestBody FlightDataTransfer flightDT) {
		System.out.println("Airline controller");
		Flight flight = new Flight();

		flight.setSource(flightDT.getSource());
		flight.setDestination(flightDT.getDestination());
		flight.setJourneyDate(flightDT.getJourneyDate());
		flight.setDeparture(flightDT.getDepartureTime());
		flight.setArrival(flightDT.getArrivalTime());
		flight.setEconomyClassCost(flightDT.getEconomyClassCost());
		flight.setBusinessClassCost(flightDT.getBusinessClassCost());
		flight.setNoOfSeats(flightDT.getNoOfSeats());
		flight.setEconomySeats(flightDT.getEconomySeats());
		flight.setBusinessSeats(flightDT.getBusinessSeats());
		System.out.println("Airline controller");
		adminService.addFlight(flight);

		return null;
	}

	@DeleteMapping("/deleteFlight")
	@PreAuthorize("hasRole('MODERATOR')")
	public String deleteFlight(@RequestParam("id") int FlightId) {
		adminService.deleteFight(FlightId);
		return null;
	}

	@GetMapping("/displayAllFlights")
	@PreAuthorize("hasRole('MODERATOR')")
	public List<Flight> displayAllFlights() {
		List<Flight> flightList = adminService.displayAllFlights();
		return flightList;
	}

	@GetMapping("/displayFlight")
	@PreAuthorize("hasRole('MODERATOR')")
	public Flight displayFlight(@RequestParam("id") int flightId) {
		System.out.println(flightId);
		Flight flight = adminService.displayFlight(flightId);
		System.out.println(flight);
		return flight;
	}

	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT,value="/displayAllFlights/{flightId}")
	public void updateFlight(@RequestBody Flight updatedFlight, @PathVariable int flightId) {
		adminService.updateFlight(updatedFlight,flightId);
	}

	@CrossOrigin
	@RequestMapping("/displayAllFlights/{flightId}")
	public Optional<Flight> getFlights(@PathVariable int flightId) {
		return adminService.findFlightById(flightId);
	}

	@PostMapping("/addFeedback")
	public String addFeedback(@RequestBody CustomerFeedback customerFeedback) {
		CustomerFeedback customerFeedback2 = new CustomerFeedback();

		customerFeedback2.setFirstName(customerFeedback.getFirstName());
		customerFeedback2.setLastName(customerFeedback.getLastName());
		customerFeedback2.setEmailFeedback(customerFeedback.getEmailFeedback());
		customerFeedback2.setMessage(customerFeedback.getMessage());

		airlineService.addFeedback(customerFeedback2);

		return null;
	}

	@GetMapping("/displayFeedbacks")
	@PreAuthorize("hasRole('ADMIN')")
	public List<CustomerFeedback> displayAllFeedbacks() {
		List<CustomerFeedback> feedbackList = adminService.displayAllFeedbacks();
		return feedbackList;
	}

	@DeleteMapping("/deleteFeedback")
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteFeedback(@RequestParam("id") int feedbackId) {
		adminService.deleteFeedback(feedbackId);
		return null;
	}

	@GetMapping("/displayFeedback")
	@PreAuthorize("hasRole('ADMIN')")
	public CustomerFeedback displayFeedback(@RequestParam("id") int feedbackId) {
		System.out.println(feedbackId);
		CustomerFeedback customerFeedback = adminService.displayFeedback(feedbackId);
		System.out.println(customerFeedback);
		return customerFeedback;
	}

	@GetMapping("/usersList")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) Long userId) {
		try {
			List<User> users = new ArrayList<User>();

			if (userId == null)
				userRepository.findAll().forEach(users::add);
			else
				userRepository.findByUserId(userId).forEach(users::add);

			if (users.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT,value="/usersList/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void updateUser(@RequestBody User updatedUser, @PathVariable long userId) {
		adminService.updateUser(updatedUser,userId);
	}

	@CrossOrigin
	@RequestMapping("/usersList/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<User> getUsers(@PathVariable long userId) {

		return userService.findUserById(userId);
	}

	@CrossOrigin
	@RequestMapping("/bookings")
	public java.util.List<Ebooking> getAllBookings() {

		return airlineService.getAllBookings();

	}

	@CrossOrigin
	@RequestMapping("/bookings/{id}")
	public Optional<Ebooking> getBookings(@PathVariable int id) {

		return airlineService.getBookings(id);
	}

	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST, value= "/bookings")
	public void addBookings(@RequestBody Ebooking newmov) {
		airlineService.addBookings(newmov);
	}



	@CrossOrigin
	@RequestMapping(method=RequestMethod.DELETE, value= "/bookings/{id}")
	public void deleteBookings(@PathVariable int id) {
		airlineService.deleteBookings(id);
	}


	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT,value="/bookings/{id}")
	public void updateBookings(@RequestBody Ebooking updatedMov, @PathVariable int id) {
		airlineService.updateBookings(updatedMov,id);
	}

	@Autowired
	PlaneRepository planeRepository;

	@GetMapping("/planes")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Plane>> getAllPlanes(@RequestParam(required = false) String model) {
		try {
			List<Plane> planes = new ArrayList<Plane>();

			if (model == null)
				planeRepository.findAll().forEach(planes::add);
			else
				planeRepository.findByModelContaining(model).forEach(planes::add);

			if (planes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(planes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/planes/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Plane> getPlanesById(@PathVariable("id") long id) {
		Optional<Plane> planeData = planeRepository.findById(id);

		if (planeData.isPresent()) {
			return new ResponseEntity<>(planeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/planes")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Plane> createPlane(@RequestBody Plane plane) {
		try {
			Plane _plane = planeRepository
					.save(new Plane(plane.getMark(), plane.getModel(), plane.getSeatsNumber(), plane.getFuel(), plane.getWeight(), plane.getAccident(),
							plane.getCycles(), false));
			return new ResponseEntity<>(_plane, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/planes/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<Plane> updatePlane(@PathVariable("id") long id, @RequestBody Plane plane) {
		Optional<Plane> planeData = planeRepository.findById(id);

		if (planeData.isPresent()) {
			Plane _plane = planeData.get();
			_plane.setMark(plane.getMark());
			_plane.setModel(plane.getModel());
			_plane.setSeatsNumber(plane.getSeatsNumber());
			_plane.setFuel(plane.getFuel());
			_plane.setWeight(plane.getWeight());
			_plane.setAccident(plane.getAccident());
			_plane.setCycles(plane.getCycles());
			_plane.setState(plane.isState());
			return new ResponseEntity<>(planeRepository.save(_plane), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/planes/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deletePlane(@PathVariable("id") long id) {
		try {
			planeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/planes")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<HttpStatus> deleteAllPlanes() {
		try {
			planeRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/planes/state")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<Plane>> findByPublished() {
		try {
			List<Plane> planes = planeRepository.findByState(true);

			if (planes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(planes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	@CrossOrigin
	@RequestMapping(method=RequestMethod.PUT,value="/displayFeedbacks/{feedbackId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void responseFeedback(@RequestBody CustomerFeedback responseMessage, @PathVariable int feedbackId) {
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("airlinepsk@gmail.com");
		message.setTo(responseMessage.getEmailFeedback());
		message.setSubject("[Reply for feedback number: "+responseMessage.getFeedbackId() + "] " + responseMessage.getSubject());
		message.setText(responseMessage.getResponseMessage());
		mailSender.send(message);
	}

	@CrossOrigin
	@RequestMapping("/displayFeedbacks/{feedbackId}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<CustomerFeedback> getFeedback(@PathVariable int feedbackId) {

		return adminService.getCustomerFeedback(feedbackId);
	}

	@GetMapping("/getFoods")
	public List<Food> getFoods() {
		return foodRepository.findAll();
	}

	@PostMapping("/upload")
	@PreAuthorize("hasRole('CREW')")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	@PostMapping("/addFood")
	@PreAuthorize("hasRole('CREW')")
	public void createFood(@RequestBody Food food) throws IOException {
		food.setPicByte(this.bytes);
		foodRepository.save(food);
		this.bytes = null;
	}

	@DeleteMapping(path = { "/{id}" })
	@PreAuthorize("hasRole('CREW')")
	public Food deleteFood(@PathVariable("id") long id) {
		Food food = foodRepository.getOne(id);
		foodRepository.deleteById(id);
		return food;
	}

	@PutMapping("/updateFood")
	@PreAuthorize("hasRole('CREW')")
	public void updateFood(@RequestBody Food food) {
		foodRepository.save(food);
	}

}
