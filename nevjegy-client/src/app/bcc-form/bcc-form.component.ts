import {Component, OnInit, Input, OnChanges, Output, EventEmitter} from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {BusinessCard} from '../BusinessCard';
import {ActivatedRoute} from '@angular/router';
import {BccService} from '../services/bcc.service';
import {Location} from '@angular/common';

@Component({
  selector: 'bcc-form',
  templateUrl: './bcc-form.component.html',
  styleUrls: ['./bcc-form.component.css']
})
export class BccFormComponent implements OnInit, OnChanges {
  bc: BusinessCard[];
  statuses: string[] = ['NEW', 'DOING', 'DONE'];
  form = this.fb.group({
    name: ['', [Validators.required]],
    address: ['', [Validators.required]],
    phone: [''],
    status: ['NEW', [Validators.required]]
  });

  @Input() bcc: BusinessCard;
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
    private bccService: BccService,
    private location: Location
  ) {
  }

  ngOnInit() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.bccService.getBcc(id).subscribe(data => {
      this.bc = data;
      this.bcc = this.bc[0];
      this.form.patchValue(this.bcc);
    });
  }

  ngOnChanges() {
    this.form.patchValue(this.bcc);
  }

  onSubmit() {
    const emittedBcc = Object.assign(this.bcc, this.form.value);
    this.bccService.postBcc(emittedBcc);
  }

}
