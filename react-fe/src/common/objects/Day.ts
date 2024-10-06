import moment, {Moment} from 'moment';

export class Day {
    private date: Moment;

    constructor(date?: Date | string) {
        if (date) {
            this.date = moment(date);
        } else {
            this.date = moment();
        }
    }

    public today(): Day {
        this.date = moment();
        return this;
    }

    public addDays(days: number): Day {
        this.date = this.date.add(days, 'days');
        return this;
    }

    public addMonths(months: number): Day {
        this.date = this.date.add(months, 'months');
        return this;
    }

    public addYears(years: number): Day {
        this.date = this.date.add(years, 'years');
        return this;
    }

    public addQuarters(quarters: number): Day {
        this.date = this.date.add(quarters, 'quarters');
        return this;
    }

    public getLastDayOfYear(): Day {
        const lastDay = this.date.endOf('year');
        return new Day(lastDay.toDate());
    }

    public getLastDayOfMonth(): Day {
        const lastDay = this.date.endOf('month');
        return new Day(lastDay.toDate());
    }

    public getFormattedDate(format: string = "DD-MM-YYYY"): string {
        return this.date.format(format);
    }

    public getFormattedDateTime(format: string = "DD-MM-YYYY HH:mm:ss"): string {
        return this.date.format(format);
    }

    public getDate(): Date {
        return this.date.toDate();
    }

    public getMoment(): Moment {
        return this.date;
    }
}
