import { Component, OnInit } from '@angular/core';
import { BusinessCard } from '../BusinessCard';
import { BccService } from '../bcc.service';

@Component({
  selector: 'app-bcc-list-view',
  templateUrl: './bcc-list-view.component.html',
  styleUrls: ['./bcc-list-view.component.css']
})
export class BccListViewComponent implements OnInit {

  selectedStatus = 'ALL';
  bccs: BusinessCard[] = [];
  filteredBcc: BusinessCard[] = [];
  selectedBcc: BusinessCard = null;

  constructor(
    private bccService: BccService
  ) { }

  ngOnInit() {
    this.bccService.getBccs().subscribe((data) => {
      this.bccs = data;
    });
    this.filterBcc();
  }

  filterBcc() {
    this.filteredBcc = this.selectedStatus === ''
      ? this.bccs
      : this.bccs;
  }

  // (change)="onFilterChange(group.value)"
  onFilterChange(value) {
    this.selectedStatus = value;
    this.filterBcc();
  }

  onFormSave(bcc: BusinessCard) {
    this.selectedBcc = bcc;
  }
}
