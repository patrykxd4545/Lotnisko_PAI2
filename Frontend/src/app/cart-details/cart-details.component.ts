import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { CartService } from 'src/app/services/cart.service';
import {render} from 'creditcardpayments/creditCardPayments';
@Component({
  selector: 'app-cart-details',
  templateUrl: './cart-details.component.html',
  styleUrls: ['./cart-details.component.css']
})
export class CartDetailsComponent implements OnInit {
  totalPrice: number = 0.00;
  totalQuantity: number = 0;
  cartItems: CartItem[] = [];
  constructor(private cartService: CartService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.listCartDetails();
  }
  listCartDetails() {
    // get the cart items
    this.cartItems = this.cartService.cartItems;
    // subscribe to the cart total price
    this.cartService.totalPrice.subscribe(
      data => this.totalPrice = data
    );
    // subscribe to the cart total quantity
    this.cartService.totalQuantity.subscribe(
      data => this.totalQuantity = data
    );
    // compute cart total price and quantity
    this.cartService.calculateCartTotals();
  }

  incrementQuantity(cartItem: CartItem) {
    this.cartService.addToCart(cartItem);
  }

  decrementQuantity(cartItem: CartItem) {
    this.cartService.decrementQuantity(cartItem);
    this.cartItems = this.cartService.cartItems;
  }

  remove(theCartItem: CartItem) {
    this.cartService.remove(theCartItem);
    this.cartItems = this.cartService.cartItems;
  }

  pay(){ render(
    {
      id: "#payments",
      currency: "USD",
      value: this.totalPrice,
      onApprove: (details) => {
        alert("Transaction Successfull");
      }
    }
  );}
}
