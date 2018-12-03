import {Component, OnInit} from '@angular/core';
import {BccListViewComponent} from '../bcc-list-view/bcc-list-view.component';

@Component({
  selector: 'app-searchbar',
  templateUrl: './searchbar.component.html',
  styleUrls: ['./searchbar.component.css'],
  providers: [BccListViewComponent]
})
export class SearchbarComponent implements OnInit {

  ngOnInit() {
  }

  constructor(
    private component: BccListViewComponent
  ) {
  }

  private filterBccs(filter: string): void {
    console.log(filter);
    this.component.filterBcc(filter);
  }
}
