import { Component, OnInit } from '@angular/core';
import {Food} from '../model/food';
import {UserService} from '../_services/user.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-foods',
  templateUrl: './foods.component.html',
  styleUrls: ['./foods.component.css']
})
export class FoodsComponent implements OnInit {

  foods: Array<Food>;
  foodsRecieved: Array<Food>;
  action: string;
  selectedFood: Food;
  constructor(private userService: UserService, private activedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.refreshData();
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

}
