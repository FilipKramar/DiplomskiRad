import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { NavbarService } from '../services/navbar.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  isHandset$: Observable<boolean>;
  isNavOpen?: boolean;
  isActive: boolean = true;
  isUser: boolean = false; 
  constructor(private navbarService: NavbarService) {
    this.isHandset$ = this.navbarService.isHandset$;
  }

  ngOnInit() {
    const userType = sessionStorage.getItem('isUser');
    this.isUser = userType === 'true';

    this.navbarService.getNavState().subscribe((isOpen) => {
      this.isNavOpen = isOpen;
    });
  }
}
