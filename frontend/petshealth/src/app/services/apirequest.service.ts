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
        this.router.navigate(['/home/dashboard']);
        sessionStorage.setItem('userid', Id.toString());
      },
      (error) => {
        alert('Wrong email or password');
      }
    );
  }
  registerUser(data: any) {
    const url = `${apiUrl.key}users/register`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('User created sucessfully');
        this.router.navigate(['/login']);
      },
      (error) => {
        alert('Cant register');
      }
    );
  }
  getUsersPets() {
    const userId = sessionStorage.getItem('userid');
    const url = `${apiUrl.key}users/pets/${userId}`;
    return this.http.get<void>(url);
  }

  registerAPet(data: any) {
    const url = `${apiUrl.key}pets`;
    this.http.post<void>(url, data).subscribe(
      () => {
        alert('Pet created sucessfully');
        this.router.navigate(['/home/dashboard/']);
      },
      (error) => {
        alert('Cant create pet');
      }
    );
  }


}
