import { Detail } from "../detail/detail";
import { Job } from "../job/job";

export class Offer {
    offer_id!: number;
    offer_name!: string;
    description!: string;
    price!: number;
    rating!: number;
    details!: Detail[];
    jobs!: Job[];
}
