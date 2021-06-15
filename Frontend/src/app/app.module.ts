import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule} from '@angular/material/core';
import { MatInputModule } from '@angular/material/input';
import { MatChipsModule} from '@angular/material/chips';


import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { FooterComponent } from './footer/footer.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { BoardCrewComponent } from './board-crew/board-crew.component';
import { SidebarComponent } from './sidebar/sidebar.component';
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
import { AddFoodComponent } from './foods/add-food/add-food.component';
import { ViewFoodComponent } from './foods/view-food/view-food.component';
import { UserShopComponent } from './user-shop/user-shop.component';
import { CartDetailsComponent } from './cart-details/cart-details.component';



@NgModule({
  declarations: [

    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,

    FooterComponent,
    BoardCrewComponent,
    SidebarComponent,
    PageNotFoundComponent,
    AddFeedbackComponent,
    FeedbackAddedComponent,
    DisplayFeedbacksComponent,
    UsersListComponent,
    AddFlightComponent,
    DisplayAllFlightComponent,
    FlightSearchComponent,
    BookFlightComponent,
    DisplayBookingsComponent,
    BookEticketComponent,
    EbookingListComponent,
    EbookingDetailsComponent,
    EbookingUpdateComponent,
    AddPlaneComponent,
    PlaneListComponent,
    PlaneDetailsComponent,
    PaymentGuiComponent,
    UsersUpdateComponent,
    DisplayAllFlightUpdateComponent,
    ResponseFeedbackComponent,
    FoodsComponent,
    AddFoodComponent,
    ViewFoodComponent,
    UserShopComponent,
    CartDetailsComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatInputModule,
    MatChipsModule
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
