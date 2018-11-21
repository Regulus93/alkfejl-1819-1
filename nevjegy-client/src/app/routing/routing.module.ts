import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { MainPageComponent } from '../main-page/main-page.component';
import { BccFormComponent } from '../bcc-form/bcc-form.component';
import { BccViewComponent } from '../bcc-view/bcc-view.component';
import { LoginViewComponent } from '../login-view/login-view.component';
import { BccListViewComponent } from '../bcc-list-view/bcc-list-view.component';
import { UserFormComponent } from '../user-form/user-form.component';
import { UserViewComponent } from '../user-view/user-view.component';
import { ProfileDisplayComponent } from '../profile-display/profile-display.component';

const routes: Routes = [
  {
    path: '',
    component: MainPageComponent
  },
  {
    path: 'bccs',
    component: BccListViewComponent
  },
  {
    path: 'login-view',
    component: LoginViewComponent
  },
  {
    path: 'bcc-form',
    component: BccFormComponent
  },
  {
    path: 'user-form',
    component: UserFormComponent
  },
  {
    path: 'bcc-list-view',
    component: BccListViewComponent
  },
  {
    path: 'user-view',
    component: UserViewComponent
  },
  {
    path: 'profile-display',
    component: ProfileDisplayComponent
  },
  {
    path: 'bcc-view/:id',
    component: BccViewComponent
  },
  {
    path: 'issues/:id/edit',
    component: BccFormComponent
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
