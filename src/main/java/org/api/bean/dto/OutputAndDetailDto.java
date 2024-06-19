package org.api.bean.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OutputAndDetailDto {
     public OutputPlanModel outputPlan;
     public List<OutputPlanDetailModel> detailList;

     @Override
     public String toString() {
          return "OutputAndDetailDto{" +
                  "outputPlan=" + outputPlan +
                  ", detailList=" + detailList +
                  '}';
     }
}
