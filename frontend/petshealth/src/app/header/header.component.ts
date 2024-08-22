import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { NavbarService } from '../services/navbar.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent {
  isHandset$: Observable<boolean>;
  isNavOpen: boolean = false;
  isUser: boolean = false; 
  constructor(
    private navbarService: NavbarService,  private router: Router  ) {
    this.isHandset$ = this.navbarService.isHandset$;
  }
  toggleNav() {
    this.isNavOpen = !this.isNavOpen;
    this.navbarService.toggleNavState(this.isNavOpen);
  }
  logout() {
    sessionStorage.removeItem('userid');
    this.router.navigate(['']);
  }
  navigateToSelectPet() {
    
    this.router.navigate(['/home/dashboard']);

  }
  ngOnInit() {
    const userType = sessionStorage.getItem('isUser');
    this.isUser = userType === 'true'; }
}
