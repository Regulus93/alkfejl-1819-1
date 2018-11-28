import { Component, OnInit, ViewChild } from '@angular/core';
import { BusinessCard } from '../BusinessCard';
import { BccService } from '../services/bcc.service';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-bcc-list-view',
  templateUrl: './bcc-list-view.component.html',
  styleUrls: ['./bcc-list-view.component.css'],
  providers: [AuthService]
})
export class BccListViewComponent implements OnInit {

  selectedStatus = 'ALL';
  bccs: BusinessCard[] = [];
  filteredBcc: BusinessCard[] = [];
  selectedBcc: BusinessCard = null;

  dummyBusinessCards: BusinessCard[] = [];

  constructor(
    private bccService: BccService,
    private authService: AuthService
  ) { 
    let dummyBusinessCard = new BusinessCard();
    dummyBusinessCard.id = 1;
    dummyBusinessCard.name = 'Dummy';
    dummyBusinessCard.phone = '+3424234234';
    dummyBusinessCard.category = 'Example data';
    dummyBusinessCard.address = 'Tokyo';

    this.dummyBusinessCards.push(dummyBusinessCard);
  }

  ngOnInit() {
    this.bccService.getBccs().subscribe((data) => {
      this.bccs = data;
    });
    this.filterBcc();
  }

  filterBcc() {
    this.filteredBcc = this.bccs;
  }

  onFormSave(bcc: BusinessCard) {
    this.selectedBcc = bcc;
  }

  isLoggedIn() {
    return this.authService.getUser() != null;
  }

  selectBcc(bcc: BusinessCard){
    if(this.selectedBcc == null){
      this.selectedBcc = bcc;
    } else {
      this.selectedBcc = null;
    }
  }
}
