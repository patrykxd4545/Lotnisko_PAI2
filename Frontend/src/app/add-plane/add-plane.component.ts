import { Component, OnInit } from '@angular/core';
import {Plane} from '../model/plane.model';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-add-plane',
  templateUrl: './add-plane.component.html',
  styleUrls: ['./add-plane.component.css']
})
export class AddPlaneComponent implements OnInit {

  plane: Plane = {
    mark: '',
    model: '',
    seatsNumber: '',
    fuel: '',
    weight: '',
    accident: '',
    cycles: '',
    state: false
  };
  submitted = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  savePlane(): void {
    const data = {
      mark: this.plane.mark,
      model: this.plane.model,
      seatsNumber: this.plane.seatsNumber,
      fuel: this.plane.fuel,
      weight: this.plane.weight,
      accident: this.plane.accident,
      cycles: this.plane.cycles
    };

    this.userService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });

  }

  newPlane(): void {
    this.submitted = false;
    this.plane = {
      mark: '',
      model: '',
      seatsNumber: '',
      fuel: '',
      weight: '',
      accident: '',
      cycles: '',
      state: false
    };
  }

}
