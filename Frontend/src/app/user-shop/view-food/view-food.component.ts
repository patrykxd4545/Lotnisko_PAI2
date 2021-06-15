import {Component, Input, OnInit, EventEmitter, Output} from '@angular/core';
import {Food} from '../../model/food';
import {UserService} from '../../_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-view-food',
  templateUrl: './view-food.component.html',
  styleUrls: ['./view-food.component.css']
})
export class ViewFoodComponent implements OnInit {

  @Input()
  food: Food;

  @Output()
  foodDeletedEvent = new EventEmitter();
  constructor(private userService: UserService, private router: Router) { }

  ngOnInit() {

  }
  deleteFood() {
    this.userService.deleteFood(this.food.id).subscribe(
      (food) => {
        this.foodDeletedEvent.emit();
        this.router.navigate(['user/foods']);
      }
    );
  }

  editFood() {
    this.router.navigate(['user', 'foods'], { queryParams: { action: 'edit', id: this.food.id } });
  }

}
