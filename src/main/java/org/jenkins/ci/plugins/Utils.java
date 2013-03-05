package org.jenkins.ci.plugins;

import hudson.model.Job;
import hudson.plugins.violations.hudson.AbstractViolationsProjectAction;

public class Utils {

    public static String getViolations(Job<?, ?> job, String type) {
        try {
            AbstractViolationsProjectAction action = job
                    .getAction(AbstractViolationsProjectAction.class);
            int count = action.getViolationsAction().getReport()
                    .getTypeReports().get(type).getNumber();
            if (count < 0) {
                return "N/A";
            }
            return String.valueOf(count);
        } catch (NullPointerException e) {
            return "N/A";
        }
    }
}
