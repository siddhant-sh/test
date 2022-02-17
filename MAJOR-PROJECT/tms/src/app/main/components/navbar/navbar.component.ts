import { Component, OnInit } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { AuthService } from 'src/app/auth/utility/auth.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})

export class NavbarComponent implements OnInit {
  welcome: Boolean = false;
  login: Boolean = false;
  register: Boolean = false;
  about: Boolean = false;
  contact: Boolean = false;
  currentRoute: any;
  isLogged: Boolean = false;
  home :string="/welcome";

  constructor(private router: Router, private _authServ :AuthService) {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.login = false;
        this.welcome = false;
        this.register = false;
        this.about = false;
        this.contact = false;
        this.currentRoute = event.url;
        this.toggleNav();
        if (this.currentRoute == this.home) {
          this.welcome = true;
        }
        if (this.currentRoute == '/auth/login') {
          this.login = true;
        }
        if (this.currentRoute == '/auth/registertutor' || this.currentRoute == '/auth/registerstudent') {
          this.register = true;
        }
        if (this.currentRoute == '/#About') {
          this.about = true;
        }
        if (this.currentRoute == '/#contact') {
          this.contact = true;
        }
      }
    });

  }
  ngOnInit(): void { }

  toggleNav() {
    if (sessionStorage['token'])
    {
      this.isLogged = true;
      let jwt = sessionStorage['token']
      let decodedJwtData = JSON.parse(window.atob(jwt.split('.')[1]))
      if(decodedJwtData.isAdmin)
      this.home='/adminhome/admin/reports';
      if(decodedJwtData.isTutor)
      this.home='/tutorhome/tutor/profile';
      if(decodedJwtData.isStudent)
      this.home='/studenthome/student/profile';
    }
    else
    {
      this.isLogged = false;
    }
  }
  logout(){
    this._authServ.logout();
  }
}
