import {ChangeDetectionStrategy, Component, HostListener, Input, OnInit} from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';

import {Review} from '../../shared/models/review.model';

@Component({
  selector: 'app-home-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.less'],
  animations: [
    trigger('slides', [
      state('in', style({
        opacity: 1
      })),
      state('out', style({
        opacity: 0
      })),
      transition('* <=> *', [
        animate(150)
      ])
    ]),
  ],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class ReviewsComponent implements OnInit {
  @Input() reviews: Review[] = [];
  screenWidth: number;
  startIndex = 0;
  itemsPerSlide = 2;
  activatedSlides: number[] = [];
  slidesState = 'in';

  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
    this.changeActivatedSlidesArray();
    this.subscribeToItemsPerSlide();
  }

  subscribeToItemsPerSlide(): void {
    this.itemsPerSlide = this.screenWidth > 770 ? 2 : 1;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event): void {
    this.screenWidth = event.target.innerWidth;
  }

  changeActivatedSlidesArray(): void {
    this.activatedSlides = [];
    for (let i = 0; i < this.itemsPerSlide; i++) {
      this.activatedSlides.push(this.startIndex + i);
    }
  }

  changeSlides(index: number): void {
    this.changeState();
    setTimeout(() => {
      this.startIndex = Math.trunc(index / this.itemsPerSlide) * this.itemsPerSlide;
      this.changeActivatedSlidesArray();
    }, 150);
  }

  onDone($event): void {
    this.slidesState = 'in';
  }

  changeState(): void {
    this.slidesState = 'out';
  }
}
