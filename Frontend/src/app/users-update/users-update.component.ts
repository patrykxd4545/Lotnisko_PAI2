import { Component, OnInit } from '@angular/core';
import {Ebooking} from '../model/ebooking';
import {User} from '../model/user-list';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../_services/user.service';


@Component({
  selector: 'app-users-update',
  templateUrl: './users-update.component.html',
  styleUrls: ['./users-update.component.css']
})
export class UsersUpdateComponent implements OnInit {

  userId: number;
  user: User;
  constructor(private route: ActivatedRoute, private router: Router,  private userService: UserService) { }

  ngOnInit() {
    this.user = new User();

    this.userId = this.route.snapshot.params['userId'];

    this.userService.getUser(this.userId)
      .subscribe(data => {
        console.log(data);
        this.user = data;
      }, error => console.log(error));
  }

  updateUser() {
    this.userService.updateUser(this.userId, this.user)
      .subscribe(data => {
        console.log(data);
        this.user = new User();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateUser();
  }

  gotoList() {
    this.router.navigate(['/admin/displayUsers']);
  }

}
