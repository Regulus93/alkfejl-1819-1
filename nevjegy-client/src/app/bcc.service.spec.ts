import { TestBed } from '@angular/core/testing';

import { BccService } from './services/bcc.service';

describe('IssueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BccService = TestBed.get(BccService);
    expect(service).toBeTruthy();
  });
});
