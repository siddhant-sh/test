import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { FooterComponent } from './main/components/footer/footer.component';
import { WelcomeComponent } from './main/components/welcome/welcome.component';
import { PagenotfoundComponent } from './main/components/pagenotfound/pagenotfound.component';
import { AdminhomeComponent } from './main/components/adminhome/adminhome.component';
import { TutorhomeComponent } from './main/components/tutorhome/tutorhome.component';
import { StudenthomeComponent } from './main/components/studenthome/studenthome.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { NavbarComponent } from './main/components/navbar/navbar.component';
import { BarRatingModule } from 'ngx-bar-rating';
import { ChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    WelcomeComponent,
    PagenotfoundComponent,
    AdminhomeComponent,
    TutorhomeComponent,
    StudenthomeComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    BarRatingModule,
    ChartsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
