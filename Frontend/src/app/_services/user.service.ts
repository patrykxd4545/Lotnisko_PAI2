import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../common/app.constants';
import {CustomerFeedback} from '../model/customer-feedback';
import {FlightDt} from '../model/flight-dt';
import {SearchFlightDT} from '../model/search-flight-dt';
import {BookingDt} from '../model/booking-dt';
import {Plane} from '../model/plane.model';
import {Food} from '../model/food';

const httpOptions = {
		  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
		};


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/api/bookings';
  private baseUrl2 = 'http://localhost:8080/api/usersList';
  private baseUrl3 = 'http://localhost:8080/api/displayAllFlights';
  private baseUrl4 = 'http://localhost:8080/api/displayFeedbacks';
  constructor(private http: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'admin', { responseType: 'text' });
  }

  getCrewBoard(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'crew', { responseType: 'text' });
  }

  getCurrentUser(): Observable<any> {
    return this.http.get(AppConstants.API_URL + 'user/me', httpOptions);
  }

  addFeedback(customerFeedback: CustomerFeedback): Observable<any>{
    return this.http.post(AppConstants.API_URL + 'addFeedback', customerFeedback);
  }

  displayFeedbacks(): Observable<any>{
    return this.http.get(AppConstants.API_URL + 'displayFeedbacks');
  }

  deleteFeedback(feedbackId: number): Observable<any>{
    return this.http.delete(AppConstants.API_URL + 'deleteFeedback?id=' + feedbackId);
  }

  responseFeedback(feedbackId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl4}/${feedbackId}`, value);
  }

  getFeedback(feedbackId: number): Observable<any> {
    return this.http.get(`${this.baseUrl4}/${feedbackId}`);
  }

  usersList(): Observable<any>{
    return this.http.get(AppConstants.API_URL + 'usersList');
  }

  fetchFlights(flightDT: FlightDt): Observable<any>{
    return this.http.post(AppConstants.API_URL + 'addFlight', flightDT);
  }

  displayAllFlights(): Observable<any>{
    return this.http.get(AppConstants.API_URL + 'displayAllFlights');
  }

  deleteFlight(flightId: number): Observable<any>{
    return this.http.delete(AppConstants.API_URL + 'deleteFlight?id=' + flightId);
  }

  updateFlight(flightId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl3}/${flightId}`, value);
  }

  getFlights(flightId: number): Observable<any> {
    return this.http.get(`${this.baseUrl3}/${flightId}`);
  }
  ///
  deleteUser(userId: number): Observable<any>{
    return this.http.delete(AppConstants.API_URL + 'deleteUser?id=' + userId);
  }

  updateUser(userId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl2}/${userId}`, value);
  }

  getUser(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl2}/${userId}`);
  }

  searchFlight(flightSearchDT: SearchFlightDT): Observable<any>{
    return this.http.post(AppConstants.API_URL + 'searchFlights', flightSearchDT);
  }

  addBooking(bookingDT: BookingDt):Observable<any>{
    return this.http.post(AppConstants.API_URL + 'addBooking', bookingDT);
  }
  updateBooking(bookingId: number):Observable<any>{
    return this.http.get(AppConstants.API_URL + 'updateBooking?bookingId=' + bookingId);
  }
  displayBookings(userId:Number):Observable<any>{
    return this.http.get(AppConstants.API_URL + 'fetchBooking?userId=' + userId);
  }
  cancelBooking(bookingId:number):Observable<any>{
    return this.http.get(AppConstants.API_URL + 'cancelTicket?bookingId=' + bookingId);
  }

  generateTicket(bookingId:Number):Observable<any>{
    return this.http.get(AppConstants.API_URL + 'fetchTicket?bookingId=' + bookingId);
  }


  getBooking(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createBooking(booking: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, booking);
  }

  updateBookings(id: string, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteBooking(id: string): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getBookingList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(AppConstants.API_URL + 'planes', data);
  }

  getAll(): Observable<Plane[]> {
    return this.http.get<Plane[]>(AppConstants.API_URL + 'planes');
  }

  get(id: any): Observable<Plane> {
    return this.http.get(`${AppConstants.API_URL + 'planes'}/${id}`);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${AppConstants.API_URL + 'planes'}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${AppConstants.API_URL + 'planes'}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(AppConstants.API_URL + 'planes');
  }

  findByModel(model: any): Observable<Plane[]> {
    return this.http.get<Plane[]>(`${AppConstants.API_URL + 'planes'}?model=${model}`);
  }

  getFoods() {
    return this.http.get<Food[]>(AppConstants.API_URL + 'getFoods');
  }

  addFood(newFood: Food) {
    return this.http.post<Food>(AppConstants.API_URL + 'addFood', newFood);
  }

  deleteFood(id) {
    return this.http.delete<Food>(AppConstants.API_URL + id);
  }

  updateFood(updatedFood: Food) {
    return this.http.put<Food>(AppConstants.API_URL + 'updateFood', updatedFood);
  }

}
