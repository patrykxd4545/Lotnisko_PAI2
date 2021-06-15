import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];

  totalPrice: Subject<number> = new Subject<number>();
  totalQuantity: Subject<number> = new Subject<number>();

  constructor() { }

  addToCart(theCartItem: CartItem) {
    // Check if the item is already in the cart
    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if (this.cartItems.length > 0) {
    // find the item in the cart based on item id
      existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id === theCartItem.id);
    }

    // check if found
    alreadyExistsInCart = (existingCartItem != undefined);
    if (alreadyExistsInCart) {
      // increment the quantity
      existingCartItem.quantity++;
    } else {
      // add to cart item to array
      this.cartItems.push(theCartItem);
    }

    // calculate cart total price and total quantity
    this.calculateCartTotals();
  }

  calculateCartTotals() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for (const tempCartItem of this.cartItems) {
      totalPriceValue += tempCartItem.price * tempCartItem.quantity;
      totalQuantityValue += tempCartItem.quantity;
    }

    // publish the new values. This will publish events to all subscribers will receive the new data
    // one event for total price and one event for total quantity
    // .next publishes/sends event
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    this.logCartData(totalPriceValue, totalQuantityValue);
  }

  logCartData(totalPriceValue: number, totalQuantityValue: number) {
    console.log('contents of the cart ');

    for (const tempCartItem of this.cartItems) {
      const subtotalPrice = tempCartItem.quantity * tempCartItem.price;
      console.log(`name: ${tempCartItem.name}, quantity: ${tempCartItem.quantity},
       unitPrice: ${tempCartItem.price}, subtotalPrice: ${subtotalPrice}`);
    }

    console.log(`totalPrice: ${totalPriceValue.toFixed(2)}, totalQuantity: ${totalQuantityValue}`);
    console.log('------------------------------------------------');
  }

  decrementQuantity(theCartItem: CartItem) {
    theCartItem.quantity--;

    if (theCartItem.quantity === 0) {
      this.cartItems = this.cartItems.filter(cartItem => cartItem.id != theCartItem.id);
      // const itemIndex = this.cartItems.findIndex(cartItem => cartItem.id === theCartItem.id);
      // if (itemIndex > -1) {
      //   this.cartItems.splice(itemIndex, 1);
      // }
      this.calculateCartTotals();
    } else {
      this.calculateCartTotals();
    }
  }

  remove(theCartItem: CartItem) {
    this.cartItems = this.cartItems.filter(cartItem => cartItem.id != theCartItem.id);
    this.calculateCartTotals();
  }
}
