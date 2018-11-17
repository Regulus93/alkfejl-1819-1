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

  statuses: string[] = ['NEW', 'DOING', 'DONE'];
  form = this.fb.group({
    title: ['', [Validators.required]],
    place: ['', [Validators.required, Validators.pattern('PC\\d+')]],
    description: [''],
    status: ['NEW', [Validators.required]]
  });
  @Input() issue: any = {
    id: null,
    name: '',
    phone: '',
    address: '',
    status: 'NEW',
    updated_at: ''
  };
  @Output() save = new EventEmitter<BusinessCard>();

  get title() {
    return this.form.get('title');
  }

  get place() {
    return this.form.get('place');
  }

  get description() {
    return this.form.get('description');
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
    this.issue = this.issueService.getIssue(id);
    this.form.patchValue(this.issue);
  }

  ngOnChanges() {
    this.form.patchValue(this.issue);
  }

  onSubmit() {
    const emittedIssue = Object.assign(this.issue, this.form.value);
    this.save.emit(emittedIssue);
    this.location.back();
  }

}
