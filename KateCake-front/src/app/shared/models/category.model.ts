import {Product} from './product.model';

export class Category {
  constructor(public name: string,
              public catalogImagePath: string,
              public mainImagePath: string,
              public mainImageOnHover: string,
              public detailedText: string,
              public enumEquivalent: string,
              public items: Product[]
  ) {
  }
}
