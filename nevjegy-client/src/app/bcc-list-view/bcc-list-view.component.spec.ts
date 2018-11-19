import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BccListViewComponent } from './bcc-list-view.component';

describe('BccListViewComponent', () => {
  let component: BccListViewComponent;
  let fixture: ComponentFixture<BccListViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BccListViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BccListViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
