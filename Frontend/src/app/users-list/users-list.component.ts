import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user-list';
import { UserService } from 'src/app/_services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {
  users?: User[];
  currentUsers?: User;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.usersList();
  }

  usersList(): void {
    this.userService.usersList()
      .subscribe(
        data => {
          this.users = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  ///
  delete(userId: number){
    this.userService.deleteUser(userId).subscribe(response => {
      this.userService.usersList().subscribe(response1 => {
        this.users = response1;
      });
    });
  }

  updateUser(userId: number){

    this.router.navigate(['admin/userUpdate', userId]);

  }

}
