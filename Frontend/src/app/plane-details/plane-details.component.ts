import { Component, OnInit } from '@angular/core';
import {Plane} from '../model/plane.model';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';

@Component({
  selector: 'app-plane-details',
  templateUrl: './plane-details.component.html',
  styleUrls: ['./plane-details.component.css']
})
export class PlaneDetailsComponent implements OnInit {

  currentPlane: Plane = {
    mark: '',
    model: '',
    seatsNumber: '',
    fuel: '',
    weight: '',
    accident: '',
    cycles: '',
    state: false
  };
  message = '';

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.message = '';
    this.getPlane(this.route.snapshot.params.id);
  }

  getPlane(id: string): void {
    this.userService.get(id)
      .subscribe(
        data => {
          this.currentPlane = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  updateStated(status: boolean): void {
    const data = {
      mark: this.currentPlane.mark,
      model: this.currentPlane.model,
      seatsNumber: this.currentPlane.seatsNumber,
      fuel: this.currentPlane.fuel,
      weight: this.currentPlane.weight,
      accident: this.currentPlane.accident,
      cycles: this.currentPlane.cycles,
      state: status
    };

    this.message = '';

    this.userService.update(this.currentPlane.id, data)
      .subscribe(
        response => {
          this.currentPlane.state = status;
          console.log(response);
          this.message = response.message ? response.message : 'This plane was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  updatePlane(): void {
    this.message = '';

    this.userService.update(this.currentPlane.id, this.currentPlane)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This plane was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deletePlane(): void {
    this.userService.delete(this.currentPlane.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/admin/planes']);
        },
        error => {
          console.log(error);
        });
  }
}
