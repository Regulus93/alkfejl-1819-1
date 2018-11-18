import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { IssueListComponent } from '../issue-list/issue-list.component';
import { MainPageComponent } from '../main-page/main-page.component';
import { IssueFormComponent } from '../issue-form/issue-form.component';

const routes: Routes = [
  {
    path: '',
    component: MainPageComponent
  },
  {
    path: 'issues',
    component: IssueListComponent
  },
  // {
  //   path: 'issues/new',
  //   component: IssueFormComponent
  // },
  // {
  //   path: 'issues/:id',
  //   component: IssueDetailComponent
  // },
  {
    path: 'issues/:id/edit',
    component: IssueFormComponent
  },
];

@NgModule({
  imports: [ RouterModule.forRoot(routes)  ],
  exports: [ RouterModule ],
  declarations: []
})
export class RoutingModule { }
