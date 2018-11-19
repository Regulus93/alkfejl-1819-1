import {Component, OnInit, Input, OnChanges, Output, EventEmitter} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {BusinessCard} from '../BusinessCard';
import {ActivatedRoute} from '@angular/router';
import {IssueService} from '../issue.service';
import {Location} from '@angular/common';

@Component({
  selector: 'issue-form',
  templateUrl: './issue-form.component.html',
  styleUrls: ['./issue-form.component.css']
})
export class IssueFormComponent implements OnInit, OnChanges {
  bc: BusinessCard[];
  statuses: string[] = ['NEW', 'DOING', 'DONE'];
  form = this.fb.group({
    name: ['', [Validators.required]],
    address: ['', [Validators.required]],
    phone: [''],
    status: ['NEW', [Validators.required]]
  });
  @Input() issue: BusinessCard;
  @Output() save = new EventEmitter<BusinessCard>();

  get name() {
    return this.form.get('name');
  }

  get address() {
    return this.form.get('address');
  }

  get phone() {
    return this.form.get('phone');
  }

  get status() {
    return this.form.get('status');
  }


  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private issueService: IssueService,
    private location: Location
  ) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.issueService.getIssue(id).subscribe(data => {
      this.bc = data;
      this.issue = this.bc[0];
      this.form.patchValue(this.issue);
    });
  }

  ngOnChanges() {
    this.form.patchValue(this.issue);
  }

  onSubmit() {
    const emittedIssue = Object.assign(this.issue, this.form.value);
    this.issueService.postIssue(emittedIssue);
  }

}
