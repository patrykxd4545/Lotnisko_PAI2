import { Component, OnInit } from '@angular/core';
import {Food} from "../model/food";
import { CartItem } from 'src/app/common/cart-item';
import {UserService} from "../_services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-user-shop',
  templateUrl: './user-shop.component.html',
  styleUrls: ['./user-shop.component.css']
})
export class UserShopComponent implements OnInit {
  products: Food[] = [];
  totalPrice: number = 0.00;
  totalQuantity: number = 0;
  foods: Array<Food>;
  foodsRecieved: Array<Food>;
  action: string;
  selectedFood: Food;
  constructor(private userService: UserService, private activedRoute: ActivatedRoute, private router: Router,private cartService: CartService) { }

  ngOnInit() {
    this.refreshData();
    this.updateCartStatus();
  }

  refreshData()
  {
    this.userService.getFoods().subscribe(
      response => this.handleSuccessfulResponse(response)
    );
    this.activedRoute.queryParams.subscribe(
      (params) => {
        // get the url parameter named action. this can either be add or view.
        this.action = params['action'];
        // get the parameter id. this will be the id of the book whose details
        // are to be displayed when action is view.
        const id = params['id'];
        // if id exists, convert it to integer and then retrive the book from
        // the books array
        if (id) {
          this.selectedFood = this.foods.find(foods => {
            return foods.id === +id;
          });
        }
      }
    );
  }
  updateCartStatus() {
    // subscribe to the cart total price
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );
    // Subscribe to the cart total quantity
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );
  }
  // we will be taking the books response returned from the database
  // and we will be adding the retrieved
  handleSuccessfulResponse(response) {
    this.foods = new Array<Food>();
    //get books returned by the api call
    this.foodsRecieved = response;
    for (const foods of this.foodsRecieved) {

      const foodswithRetrievedImageField = new Food();
      foodswithRetrievedImageField.id = foods.id;
      foodswithRetrievedImageField.name = foods.name;
      //populate retrieved image field so that book image can be displayed
      foodswithRetrievedImageField.retrievedImage = 'data:image/jpeg;base64,' + foods.picByte;
      foodswithRetrievedImageField.description = foods.description;
      foodswithRetrievedImageField.price = foods.price;
      foodswithRetrievedImageField.picByte = foods.picByte;
      this.foods.push(foodswithRetrievedImageField);
    }
  }

  addFood() {
    this.selectedFood = new Food();
    this.router.navigate(['user', 'foods'], { queryParams: { action: 'add' } });
  }

  viewFood(id: number) {
    this.router.navigate(['user', 'foods'], { queryParams: { id, action: 'view' } });
  }
  addToCart(theProduct: Food) {
    console.log(`Adding to cart: ${theProduct.name}, ${theProduct.price}`);

    const theCartItem = new CartItem(theProduct);

    this.cartService.addToCart(theCartItem);
  }
  doSearch(value: string) {
    console.log(`value=${value}`);
    this.router.navigateByUrl(`/search/${value}`);
  }

}
