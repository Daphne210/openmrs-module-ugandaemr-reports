package org.openmrs.module.ugandaemrreports.library;

import org.openmrs.module.reporting.cohort.definition.CohortDefinition;
import org.openmrs.module.reporting.evaluation.parameter.Mapped;
import org.openmrs.module.reporting.evaluation.parameter.Parameter;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.openmrs.module.reporting.indicator.aggregation.Aggregator;

import java.util.Date;
import java.util.Map;

public class Indicators {

    public static CohortIndicator newCountIndicator(String name, CohortDefinition cohort, Map<String, Object> map) {
        CohortIndicator i = CohortIndicator.newCountIndicator(name, new Mapped<CohortDefinition>(cohort, map), null);
        i.addParameter(new Parameter("startDate", "Start date", Date.class));
        i.addParameter(new Parameter("endDate", "End date", Date.class));
        return i;
    }

    public static CohortIndicator newFractionIndicator(String name, CohortDefinition numerator, Map<String, Object> numeratorMap,
                                                       CohortDefinition denominator, Map<String, Object> denominatorMap) {
        CohortIndicator i = CohortIndicator.newFractionIndicator(name,
                new Mapped<CohortDefinition>(numerator, numeratorMap),
                new Mapped<CohortDefinition>(denominator, denominatorMap), null);
        i.addParameter(new Parameter("startDate", "Start date", Date.class));
        i.addParameter(new Parameter("endDate", "End date", Date.class));

        return i;
    }

    public static CohortIndicator newLogicIndicator(String name, CohortDefinition logic, Map<String, Object> map,
                                                    Class<? extends Aggregator> aggregator, String logicName) {
        CohortIndicator i = CohortIndicator.newLogicIndicator(name, new Mapped<CohortDefinition>(logic, map), null,
                aggregator, logicName);
        i.addParameter(new Parameter("startDate", "Start date", Date.class));
        i.addParameter(new Parameter("endDate", "End date", Date.class));

        return i;
    }

    public static CohortIndicator newCohortIndicator(String name, CohortDefinition cohort, Map<String, Object> map) {
        CohortIndicator i = new CohortIndicator();
        i.setName(name);
        i.setCohortDefinition(new Mapped<CohortDefinition>(cohort, map));
        i.addParameter(new Parameter("startDate", "Start date", Date.class));
        i.addParameter(new Parameter("endDate", "End date", Date.class));

        return i;
    }
}
