import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatToolbarModule,
  MatIconModule,
  MatButtonModule,
  MatListModule,
  MatButtonToggleModule,
  MatInputModule,
  MatFormFieldModule,
  MatSidenavModule,
  MatSelectModule,
  MatCardModule
} from '@angular/material';
import { MainPageComponent } from './main-page/main-page.component';
import { RoutingModule } from './routing/routing.module';
import { StatusFilterComponent } from './status-filter/status-filter.component';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { LoginViewComponent } from './login-view/login-view.component';
import { BccListViewComponent } from './bcc-list-view/bcc-list-view.component';
import { BccFormComponent } from './bcc-form/bcc-form.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserViewComponent } from './user-view/user-view.component';
import { ProfileDisplayComponent } from './profile-display/profile-display.component';
import { SearchbarComponent } from './searchbar/searchbar.component';
import { BccViewComponent } from './bcc-view/bcc-view.component';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    StatusFilterComponent,
    LoginViewComponent,
    BccListViewComponent,
    BccFormComponent,
    UserFormComponent,
    UserViewComponent,
    ProfileDisplayComponent,
    SearchbarComponent,
    BccViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    MatSidenavModule,
    RoutingModule,
    MatCardModule,
    MatButtonToggleModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule,
	RouterModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
