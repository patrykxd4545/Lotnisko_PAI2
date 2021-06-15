import { Component, OnInit } from '@angular/core';
import {Plane} from '../model/plane.model';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-plane-list',
  templateUrl: './plane-list.component.html',
  styleUrls: ['./plane-list.component.css']
})
export class PlaneListComponent implements OnInit {

  planes?: Plane[];
  currentPlane?: Plane;
  currentIndex = -1;
  model = '';

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.retrievePlanes();
  }

  retrievePlanes(): void {
    this.userService.getAll()
      .subscribe(
        data => {
          this.planes = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  refreshList(): void {
    this.retrievePlanes();
    this.currentPlane = undefined;
    this.currentIndex = -1;
  }

  setActivePlane(plane: Plane, index: number): void {
    this.currentPlane = plane;
    this.currentIndex = index;
  }

  removeAllPlanes(): void {
    this.userService.deleteAll()
      .subscribe(
        response => {
          console.log(response);
          this.refreshList();
        },
        error => {
          console.log(error);
        });
  }

  searchModel(): void {
    this.currentPlane = undefined;
    this.currentIndex = -1;

    this.userService.findByModel(this.model)
      .subscribe(
        data => {
          this.planes = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

}
