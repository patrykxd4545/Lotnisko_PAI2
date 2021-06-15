import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from '../_services/token-storage.service';


@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  private roles: string[];
  isLoggedIn = false;


  showAdminBoard = false;
  showModeratorBoard = false;
  showCrewBoard = false;
  showUserBoard = false;


  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      this.showModeratorBoard = this.roles.includes('ROLE_MODERATOR');
      this.showCrewBoard = this.roles.includes('ROLE_CREW');
      this.showUserBoard = this.roles.includes('ROLE_USER');

    }
  }
}
