import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StartPageComponent } from './start-page/start-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MainpageComponent } from './mainpage/mainpage.component';
import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import {MatCardModule} from '@angular/material/card';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { SelectpageComponent } from './selectpage/selectpage.component';
import { RegisterpetComponent } from './registerpet/registerpet.component';
import { MatTableModule } from '@angular/material/table';
import { TherapiesComponent } from './therapies/therapies.component';
import { TherapiesdetailComponent } from './therapiesdetail/therapiesdetail.component';
import { PrescriptionsComponent } from './prescriptions/prescriptions.component';
import { PrescriptiondetailsComponent } from './prescriptiondetails/prescriptiondetails.component';
import { VisitsComponent } from './visits/visits.component';

@NgModule({
  declarations: [
    AppComponent,
    StartPageComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    MainpageComponent,
    HeaderComponent,
    NavbarComponent,
    SelectpageComponent,
    RegisterpetComponent,
    TherapiesComponent,
    TherapiesdetailComponent,
    PrescriptionsComponent,
    PrescriptiondetailsComponent,
    VisitsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSlideToggleModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FlexLayoutModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatCardModule,
    MatTableModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
