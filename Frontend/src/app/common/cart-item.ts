import { ThisReceiver } from "@angular/compiler";
import { Product } from "./product";

export class CartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
  picByte: string;
  retrievedImage: string;
  constructor(product: Product) {
    this.id = product.id;
    this.name = product.name;
    this.price = product.price;
    this.quantity = 1;
    this.retrievedImage = product.retrievedImage;
  }
}
