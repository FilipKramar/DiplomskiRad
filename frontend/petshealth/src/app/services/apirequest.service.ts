import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { apiUrl } from '../environment/environment';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ApirequestService {

  constructor(private http: HttpClient, private router: Router) {}

  loginUser(data: any) {
    const url = `${apiUrl.key}users`;
    this.http.post<number>(url, data).subscribe(
      (Id: number) => {
        this.router.navigate(['/home']);
        sessionStorage.setItem('userid', Id.toString());
      },
      (error) => {
        alert('Wrong email or password');
      }
    );
  }
}
