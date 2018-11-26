import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'status-filter',
  templateUrl: './status-filter.component.html',
  styleUrls: ['./status-filter.component.css']
})
export class StatusFilterComponent implements OnInit {

  statuses: string[] = ['NEW', 'DOING', 'DONE'];
  @Input() selectedStatus = '';
  // @Output() change = new EventEmitter<string>();

  constructor() {
  }

  ngOnInit() {
  }

  // (change)="onFilterChange(group.value)"
  // onFilterChange(value) {
    // this.selectedStatus = value;
    // this.change.emit(value);
  // }
}
