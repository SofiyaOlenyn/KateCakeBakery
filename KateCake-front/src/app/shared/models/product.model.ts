export class Product {
  constructor(public id: number,
              public name: string,
              public mainPhoto: string,
              public otherPhotos: string[],
              public ingredients: string,
              public supplements: string,
              public weight: string,
              public price: number) {
  }
}
