package org.jenkinsci.plugins.violationcolumns;

import hudson.Extension;
import hudson.model.Descriptor;
import hudson.model.Job;
import hudson.views.ListViewColumnDescriptor;
import hudson.views.ListViewColumn;
import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

public final class CpplintColumn extends ListViewColumn {

    /**
     * The plugin descriptor.
     */
    private static final class CpplintColumnDescriptor extends
            ListViewColumnDescriptor {
        @Override
        public String getDisplayName() {
            return "Violations cpplint";
        }

        @Override
        public ListViewColumn newInstance(final StaplerRequest request,
                final JSONObject formData) throws FormException {
            return new CpplintColumn();
        }

        @Override
        public boolean shownByDefault() {
            return false;
        }
    }

    /**
     * The plugin descriptor.
     */
    @Extension
    public static final Descriptor<ListViewColumn> DESCRIPTOR = new CpplintColumnDescriptor();

    @Override
    public Descriptor<ListViewColumn> getDescriptor() {
        return DESCRIPTOR;
    }
    
   
    public String getViolations(Job<?, ?> job) {
        return Utils.getViolations(job, "cpplint");
    }
}
