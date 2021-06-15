import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardCrewComponent } from './board-crew/board-crew.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { AddFeedbackComponent } from './add-feedback/add-feedback.component';
import { FeedbackAddedComponent } from './feedback-added/feedback-added.component';
import { DisplayFeedbacksComponent } from './display-feedbacks/display-feedbacks.component';
import { UsersListComponent } from './users-list/users-list.component';
import { AddFlightComponent } from './add-flight/add-flight.component';
import { DisplayAllFlightComponent } from './display-all-flight/display-all-flight.component';
import { FlightSearchComponent } from './flight-search/flight-search.component';
import { BookFlightComponent } from './book-flight/book-flight.component';
import { DisplayBookingsComponent } from './display-bookings/display-bookings.component';
import { BookEticketComponent } from './book-eticket/book-eticket.component';
import { EbookingListComponent } from './ebooking-list/ebooking-list.component';
import { EbookingDetailsComponent } from './ebooking-details/ebooking-details.component';
import { EbookingUpdateComponent } from './ebooking-update/ebooking-update.component';
import { AddPlaneComponent } from './add-plane/add-plane.component';
import { PlaneListComponent } from './plane-list/plane-list.component';
import { PlaneDetailsComponent } from './plane-details/plane-details.component';
import { PaymentGuiComponent } from './payment-gui/payment-gui.component';
import { UsersUpdateComponent } from './users-update/users-update.component';
import { DisplayAllFlightUpdateComponent } from './display-all-flight-update/display-all-flight-update.component';
import { ResponseFeedbackComponent } from './response-feedback/response-feedback.component';
import { FoodsComponent } from './foods/foods.component';
import { UserShopComponent } from './user-shop/user-shop.component';
import { CartDetailsComponent } from './cart-details/cart-details.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'mod', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  { path: 'crew', component: BoardCrewComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'user/addFeedback', component: AddFeedbackComponent },
  { path: 'user/addFeedback/added', component: FeedbackAddedComponent },
  { path: 'admin/displayFeedbacks', component: DisplayFeedbacksComponent },
  { path: 'admin/displayFeedbacks/:feedbackId', component: ResponseFeedbackComponent },
  { path: 'admin/displayUsers', component: UsersListComponent },
  { path: 'admin/userUpdate/:userId', component: UsersUpdateComponent },
  { path: 'mod/addFlight', component: AddFlightComponent },
  { path: 'mod/displayAllFlights', component: DisplayAllFlightComponent },
  { path: 'mod/allFlightsUpdate/:flightId', component: DisplayAllFlightUpdateComponent },
  { path: 'user/searchFlights', component: FlightSearchComponent },
  { path: 'user/bookFlight', component: BookFlightComponent },
  { path: 'admin/displayBookings', component: DisplayBookingsComponent },
  { path: 'user/bookEticket', component: BookEticketComponent },
  { path: 'admin/ebookingList', component: EbookingListComponent },
  { path: 'admin/ebookingDetails/:id', component: EbookingDetailsComponent },
  { path: 'admin/eticket', component: EbookingDetailsComponent },
  { path: 'admin/ebookingUpdate/:id', component: EbookingUpdateComponent },
  { path: 'admin/addPlane', component: AddPlaneComponent },
  { path: 'admin/planes', component: PlaneListComponent },
  { path: 'admin/planes/:id', component: PlaneDetailsComponent },
  { path: 'user/bookFlight/pay', component: PaymentGuiComponent },
  { path: 'user/foods', component: FoodsComponent },
  { path: 'user/shop', component: UserShopComponent },
  { path: 'cart-details', component: CartDetailsComponent },
  { path: '**' , component: PageNotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
