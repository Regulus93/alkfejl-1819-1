import { Component, OnInit } from '@angular/core';
import { BusinessCard } from '../BusinessCard';
import { BccService } from '../services/bcc.service';
import { AuthService } from '../services/auth.service';

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
    private bccService: BccService,
    private authService: AuthService
  ) { }

  ngOnInit() {
    this.bccService.getBccs().subscribe((data) => {
      this.bccs = data;
    });
    this.filterBcc();
  }

  filterBcc() {
    console.log("Selected status: " + this.selectedStatus);
    console.log("Logic part: " + this.selectedStatus === '');
    console.log("Value of bccs array: " + this.bccs);
    this.filteredBcc = this.bccs;
  }

  onFormSave(bcc: BusinessCard) {
    this.selectedBcc = bcc;
  }

  isLoggedIn() {
    return this.authService.getUser() != null;
  }
}
