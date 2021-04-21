package dao;

import entity.EntityView;
import entity.division.DivisionView;
import entity.gettingstarted.GettingStartedView;
import entity.holydayschedule.HolidaySchedule;
import entity.job.JobHeaderView;
import entity.payment.PaymentView;
import entity.post.PostView;
import entity.tableNumber.TableNumberView;
import entity.workschedule.WorkSchedule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RequestByEntityViewListTest {

    @Test
    void request() {
        /*String table = "jobs";
        int employeeId = 1;
        List<EntityView> entityViewList = new ArrayList<>();
        entityViewList.add(new JobHeaderView());
        entityViewList.add(new GettingStartedView(LocalDate.now()));
        entityViewList.add(new TableNumberView(123));
        entityViewList.add(DivisionView.ACCOUNTING);
        entityViewList.add(PostView.ACCOUNTANT);
        entityViewList.add(PaymentView.EIGHTYPERCENT);
        entityViewList.add(new HolidaySchedule("июль"));
        entityViewList.add(new WorkSchedule("два через два"));
        RequestByEntityViewList requestByEntityViewList =
                new RequestByEntityViewList(
                        table,
                        employeeId,
                        entityViewList
                );
        String request = requestByEntityViewList.request();
        System.out.println(request);*/
    }
}