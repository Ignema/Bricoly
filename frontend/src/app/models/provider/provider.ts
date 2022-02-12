import { Day } from "../day/day";
import { Job } from "../job/job";
import { Offer } from "../offer/offer";
import { Skill } from "../skill/skill";
import { User } from "../user/user";

export class Provider {
    public provider_id!: number;
    public bio!: string;
    public user!: User;
    public days!: Day[];
    public skills!: Skill[];
    public offers!: Offer[];
    public jobs!: Job[];
}
