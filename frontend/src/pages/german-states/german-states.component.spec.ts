import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GermanStatesComponent } from './german-states.component';

describe('GermanStatesComponent', () => {
  let component: GermanStatesComponent;
  let fixture: ComponentFixture<GermanStatesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GermanStatesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GermanStatesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
