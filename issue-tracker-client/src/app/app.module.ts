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
  MatSelectModule
} from '@angular/material';
import { IssueListComponent } from './issue-list/issue-list.component';
import { MainPageComponent } from './main-page/main-page.component';
import { RoutingModule } from './routing/routing.module';
import { StatusFilterComponent } from './status-filter/status-filter.component';
import { IssueFormComponent } from './issue-form/issue-form.component';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    IssueListComponent,
    MainPageComponent,
    StatusFilterComponent,
    IssueFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatListModule,
    RoutingModule,
    MatButtonToggleModule,
    MatInputModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    HttpClientModule
  ],
  providers: [HttpClientModule],
  bootstrap: [AppComponent]
})
export class AppModule { }
