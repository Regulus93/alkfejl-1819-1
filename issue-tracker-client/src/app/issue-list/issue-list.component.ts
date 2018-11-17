import { Component, OnInit } from '@angular/core';
import { BusinessCard } from '../BusinessCard';
import { IssueService } from '../issue.service';

@Component({
  selector: 'issue-list',
  templateUrl: './issue-list.component.html',
  styleUrls: ['./issue-list.component.css']
})
export class IssueListComponent implements OnInit {

  selectedStatus = 'ALL';
  issues: any = [];
  filteredIssues: BusinessCard[] = [];
  selectedIssue: BusinessCard = null;

  constructor(
    private issueService: IssueService
  ) { }

  ngOnInit() {
    this.issueService.getIssues().subscribe((data: {}) => {
      console.log(data);
      this.issues = data;
    });
    this.filterIssues();
  }

  filterIssues() {
    this.filteredIssues = this.selectedStatus === ''
      ? this.issues
      : this.issues;
  }

  // (change)="onFilterChange(group.value)"
  onFilterChange(value) {
    this.selectedStatus = value;
    this.filterIssues();
  }

  onFormSave(issue: BusinessCard) {
    this.selectedIssue = issue;
    this.selectedIssue = null;
  }
}
